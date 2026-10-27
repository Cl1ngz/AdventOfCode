def distance_traveled(speed, howlong, rest, total_time):
    cycle_time = howlong + rest
    full_cycles = total_time // cycle_time
    remaining_time = total_time % cycle_time

    distance = full_cycles * speed * howlong
    distance += min(remaining_time, howlong) * speed

    return distance


with open("../input.txt") as f:
    max_distance = 0
    distances = {}
    points = {}
    lines = f.read().strip().splitlines()
    for i in range(1, 2504):
        for line in lines:
            who, speed, howlong, rest = (
                line.split()[0],
                int(line.split()[3]),
                int(line.split()[6]),
                int(line.split()[13]),
            )
            traveled = distance_traveled(speed, howlong, rest, 2503)
            if max_distance < traveled:
                max_distance = traveled
                winner = who

            calculated_distance = distance_traveled(speed, howlong, rest, i)
            distances[who] = calculated_distance
        max_distance = max(distances.values())
        for who, distance in distances.items():
            if distance == max_distance:
                points[who] = points.get(who, 0) + 1

    print(f"Part1: {max_distance}")
    print(f"Part2: {max(points.values())}")
