import json
import re

with open("../input.txt") as f:
    data = f.read().strip()
    data_json = json.loads(data)


def part1(data):
    numbers = re.findall(r"-?\d+", data)
    return sum(int(n) for n in numbers)


def part2(obj):
    if isinstance(obj, int):
        return obj
    elif isinstance(obj, list):
        return sum(part2(x) for x in obj)
    elif isinstance(obj, dict):
        if "red" in obj.values():
            return 0
        return sum(part2(x) for x in obj.values())
    else:
        return 0


print("Part 1:", part1(data))
print("Part 2:", part2(data_json))
