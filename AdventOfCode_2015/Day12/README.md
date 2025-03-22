# Challenge Description

--- Day 11: Corporate Policy ---

## Part 1

Santa's previous password expired, and he needs help choosing a new one.

To help him remember his new password after the old one expires, Santa has devised a method of coming up with a password based on the previous one. Corporate policy dictates that passwords must be exactly eight lowercase letters (for security reasons), so he finds his new password by incrementing his old password string repeatedly until it is valid.

Incrementing is just like counting with numbers: xx, xy, xz, ya, yb, and so on. Increase the rightmost letter one step; if it was z, it wraps around to a, and repeat with the next letter to the left until one doesn't wrap around.

Unfortunately for Santa, a new Security-Elf recently started, and he has imposed some additional password requirements:

- Passwords must include one increasing straight of at least three letters, like abc, bcd, cde, and so on, up to xyz. They cannot skip letters; abd doesn't count.
- Passwords may not contain the letters i, o, or l, as these letters can be mistaken for other characters and are therefore confusing.
- Passwords must contain at least two different, non-overlapping pairs of letters, like aa, bb, or zz.

For example:

- hijklmmn meets the first requirement (because it contains the straight hij) but fails the second requirement requirement (because it contains i and l).
- abbceffg meets the third requirement (because it repeats bb and ff) but fails the first requirement.
- abbcegjk fails the third requirement, because it only has one double letter (bb).
- The next password after abcdefgh is abcdffaa.
- The next password after ghijklmn is ghjaabcc, because you eventually skip all the passwords that start with ghi..., since i is not allowed.

Given Santa's current password (your puzzle input), what should his next password be?

## Part 2

Santa's password expired again. What's the next one?

## Solution

You can find the Rust and Java solution for each part of this challenge:

- **Part 1 Solution in rust**: [`part1.rs`](rust/src/bin/part1.rs)
- **Part 2 Solution in rust**: [`part2.rs`](rust/src/bin/part2.rs)

- **Java Part 1**: [`Part1.java`](java/Part1.java)
- **Java Part 2**: [`Part2.java`](java/Part2.java)

---

## Prerequisites

To run these solutions, ensure you have Rust installed. You can install Rust using [rustup](https://rustup.rs/).

To run the Java solutions, make sure you have the Java Development Kit (JDK) installed. You can download it from [OpenJDK](https://openjdk.java.net/) or use a JDK from your system’s package manager.

## How to Run

Once Rust is installed, you can run the solutions with the following commands:

```bash
cd rust
cargo run --bin part1
# or
cargo run --bin part2
```

```bash
cd java
# For Day X Part 1
javac DayX/Part1.java
java DayX.Part1
# For Day X Part 2
javac DayX/Part2.java
java DayX.Part2
```
