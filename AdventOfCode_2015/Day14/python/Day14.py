def distance_traveled(speed, howlong, rest, total_time):
    cycle_time = howlong + rest
    full_cycles = total_time // cycle_time
    remaining_time = total_time % cycle_time

    distance = full_cycles * speed * howlong
    distance += min(remaining_time, howlong) * speed

    return distance


with open("../input.txt") as f:
    max_distance = 0
    lines = f.read().strip().splitlines()
    for line in lines:
        who, speed, howlong, rest = (
            line.split()[0],
            int(line.split()[3]),
            int(line.split()[6]),
            int(line.split()[13]),
        )
        if max_distance < distance_traveled(speed, howlong, rest, 2503):
            max_distance = distance_traveled(speed, howlong, rest, 2503)
            winner = who
    print(f"Winner: {winner} with distance: {max_distance}")
