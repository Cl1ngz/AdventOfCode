with open("../input.txt") as f:
    lines = f.readlines()


def calculate_min_wraping_papper(l, w, h):
    smallest_side_area = min(l * w, l * h, w * h)
    return 2 * (l * w + l * h + w * h) + smallest_side_area


def part1():
    total_paper = 0
    for line in lines:
        dimensions = list(map(int, line.strip().split("x")))
        l, w, h = dimensions
        # print(calculate_min_wraping_papper(l, w, h))
        total_paper += calculate_min_wraping_papper(l, w, h)

    print(f"Total wrapping paper needed: {total_paper}")


def calculate_ribbon(l, w, h):
    smallest_perimeter = min(2 * (l + w), 2 * (l + h), 2 * (w + h))
    bow_length = l * w * h
    return smallest_perimeter + bow_length


def part2():
    total_ribbon = 0
    for line in lines:
        dimensions = list(map(int, line.strip().split("x")))
        l, w, h = dimensions
        # print(calculate_ribbon(l, w, h))
        total_ribbon += calculate_ribbon(l, w, h)

    print(f"Total ribbon needed: {total_ribbon}")


part1()
part2()
