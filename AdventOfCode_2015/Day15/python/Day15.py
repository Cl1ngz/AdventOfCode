ingredients = []

with open("../input.txt") as f:
    lines = f.read().strip().splitlines()
    for line in lines:
        line = (
            line.replace(":", "")
            .replace(",", "")
            .replace("capacity", "")
            .replace("durability", "")
            .replace("flavor", "")
            .replace("texture", "")
            .replace("calories", "")
        )
        parts = line.split()
        ingredients.append(
            (int(parts[1]), int(parts[2]), int(parts[3]), int(parts[4]), int(parts[5]))
        )


def get_portions(total, num_ingredients):
    if num_ingredients == 1:
        yield (total,)
    else:
        for i in range(total + 1):
            for subportion in get_portions(total - i, num_ingredients - 1):
                yield (i,) + subportion


# def test():
#     print("start")
#     yield 1
#     print("after")
#     yield 2
#     print("end")
#
#
# for x in test():
#     print("get", x)


def calc_best_score_with_calories(ingredients, calorie_target=None):
    highest = 0
    ingred_count = len(ingredients)
    for p in get_portions(100, ingred_count):
        c = sum(p[i] * ingredients[i][0] for i in range(ingred_count))
        d = sum(p[i] * ingredients[i][1] for i in range(ingred_count))
        f = sum(p[i] * ingredients[i][2] for i in range(ingred_count))
        t = sum(p[i] * ingredients[i][3] for i in range(ingred_count))
        cal = sum(p[i] * ingredients[i][4] for i in range(ingred_count))
        c = max(c, 0)
        d = max(d, 0)
        f = max(f, 0)
        t = max(t, 0)
        if calorie_target is None:
            score = c * d * f * t
            if score > highest:
                highest = score
        elif cal == calorie_target:
            score = c * d * f * t
            if score > highest:
                highest = score
    return highest


print(f"Part1: {calc_best_score_with_calories(ingredients)}")
print(f"Part2: {calc_best_score_with_calories(ingredients, 500)}")
