with open("../input.txt") as f:
    lines = f.read().strip().splitlines()


def part1():
    total_string_code = 0
    total_memory_code = 0
    for line in lines:
        total_string_code += len(line)
        total_memory_code += len(eval(line))

    return total_string_code - total_memory_code


print(part1())


def encode_string(s):
    return '"' + s.replace("\\", "\\\\").replace('"', '\\"') + '"'


def part2():
    total_string_code = 0
    total_memory_code = 0
    for line in lines:
        encoded = encode_string(line)
        total_string_code += len(encoded)
        total_memory_code += len(line)

    return total_string_code - total_memory_code


print(part2())
