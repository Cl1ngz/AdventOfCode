import hashlib


def find_hash_with_prefix(secret_password, startswith):
    for i in range(10000000):
        md5_hash = hashlib.md5((secret_password + str(i)).encode()).hexdigest()
        if md5_hash.startswith(startswith):
            # print(i, md5_hash)
            # break
            return i


print("Part 1:", find_hash_with_prefix("ckczppom", "00000"))
print("Part 2:", find_hash_with_prefix("ckczppom", "000000"))
