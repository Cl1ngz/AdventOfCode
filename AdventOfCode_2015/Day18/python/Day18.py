import itertools

with open("../input.txt") as f:
    data = f.read().strip().splitlines()
# # mean on
# . means off

# a light that is on stays if 2-3 neighbours are on otherwise it turns off
# a light that is off turns on if exactly 3 neighbours are on otherwise it stays off


def get_neighbours_that_are_on(x, y, data):
    neighbours = [
        (x - 1, y - 1),
        (x, y - 1),
        (x + 1, y - 1),
        (x - 1, y),
        (x + 1, y),
        (x - 1, y + 1),
        (x, y + 1),
        (x + 1, y + 1),
    ]
    count = 0
    for nx, ny in neighbours:
        if 0 <= nx < len(data[0]) and 0 <= ny < len(data):
            if data[ny][nx] == "#":
                count += 1
    return count


# steps = 4
# data = """
# .#.#.#
# ...##.
# #....#
# ..#...
# #.#..#
# ####..
# """.strip().splitlines()

steps = 100


def lights(data, steps, corners_on=False):
    if corners_on:
        # turn on the corners
        data[0] = "#" + data[0][1:-1] + "#"
        data[-1] = "#" + data[-1][1:-1] + "#"
    for step in range(steps):
        new_data = []
        for y, line in enumerate(data):
            new_line = ""
            for x, c in enumerate(line):
                if (
                    (x == 0 and y == 0)
                    or (x == len(line) - 1 and y == 0)
                    or (x == 0 and y == len(data) - 1)
                    or (x == len(line) - 1 and y == len(data) - 1)
                ) and corners_on:
                    new_line += "#"
                elif c == "#" and get_neighbours_that_are_on(x, y, data) not in [2, 3]:
                    new_line += "."
                elif c == "." and get_neighbours_that_are_on(x, y, data) == 3:
                    new_line += "#"
                else:
                    new_line += c
            new_data.append(new_line)
        data = new_data

    return sum(line.count("#") for line in data)


print(f"Part 1: {lights(data, steps)}")
print(f"Part 2: {lights(data, steps, corners_on=True)}")
