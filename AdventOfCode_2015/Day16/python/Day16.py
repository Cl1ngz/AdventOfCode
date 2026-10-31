aunt_mfcsam = {
    "children": 3,
    "cats": 7,
    "samoyeds": 2,
    "pomeranians": 3,
    "akitas": 0,
    "vizslas": 0,
    "goldfish": 5,
    "trees": 3,
    "cars": 2,
    "perfumes": 1,
}


def get_aunt_mfcsam(parts):
    is_match = True
    sue_id = int(parts[1])
    for i in range(2, len(parts), 2):
        thing = parts[i]
        value = int(parts[i + 1])
        if aunt_mfcsam[thing] != value:
            is_match = False
            break
    if is_match:
        return sue_id


def get_real_aunt_mfcsam(parts):
    is_match = True
    sue_id = int(parts[1])
    for i in range(2, len(parts), 2):
        thing = parts[i]
        value = int(parts[i + 1])
        if thing in ["cats", "trees"]:
            if aunt_mfcsam[thing] >= value:
                is_match = False
                break
        elif thing in ["pomeranians", "goldfish"]:
            if aunt_mfcsam[thing] <= value:
                is_match = False
                break
        else:
            if aunt_mfcsam[thing] != value:
                is_match = False
                break
    if is_match:
        return sue_id


with open("../input.txt") as f:
    lines = f.read().strip().splitlines()
    for line in lines:
        line = line.replace(":", "").replace(",", "")
        parts = line.split()
        print(get_aunt_mfcsam(parts)) if get_aunt_mfcsam(parts) is not None else ""
        (
            print(get_real_aunt_mfcsam(parts))
            if get_real_aunt_mfcsam(parts) is not None
            else ""
        )
