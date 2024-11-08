# Challenge Description Probably a Fire Hazard

## Part 1

Because your neighbors keep defeating you in the holiday house decorating contest year after year, you've decided to deploy one million lights in a 1000x1000 grid.

Furthermore, because you've been especially nice this year, Santa has mailed you instructions on how to display the ideal lighting configuration.

Lights in your grid are numbered from 0 to 999 in each direction; the lights at each corner are at 0,0, 0,999, 999,999, and 999,0. The instructions include whether to turn on, turn off, or toggle various inclusive ranges given as coordinate pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.

To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you in order.

For example:

- turn on 0,0 through 999,999 would turn on (or leave on) every light.
- toggle 0,0 through 999,0 would toggle the first line of 1000 lights, turning off the ones that were on, and turning on the ones that were off.
- turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.

After following the instructions, how many lights are lit?

## Part 2

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
