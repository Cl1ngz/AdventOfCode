with open("../input.txt") as f:
    content = f.read()


def part1():
    up = content.count("(")
    down = content.count(")")

    print(up - down)


def part2():
    floor = 0
    for i, char in enumerate(content):
        match char:
            case "(":
                floor += 1
            case ")":
                floor -= 1

        if floor == -1:
            print(f"First time in basement at position: {i + 1}")
            break


part1()
part2()
