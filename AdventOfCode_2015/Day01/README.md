# Challenge Description
## Part 1
Santa is trying to deliver presents in a large apartment building, but he can't find the right floor - the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows the instructions one character at a time.

An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.

The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.

For example:

-    (()) and ()() both result in floor 0.
-    ((( and (()(()( both result in floor 3.
-    ))((((( also results in floor 3.
-    ()) and ))( both result in floor -1 (the first basement level).
-    ))) and )())()) both result in floor -3.

To what floor do the instructions take Santa?

## Part 2
ow, given the same instructions, find the position of the first character that causes him to enter the basement (floor -1). The first character in the instructions has position 1, the second character has position 2, and so on.

For example:

-    ) causes him to enter the basement at character position 1.
-    ()()) causes him to enter the basement at character position 5.

What is the position of the character that causes Santa to first enter the basement?

## Solution

You can find the Rust solution for each part of this challenge:

- **Part 1 Solution in rust**: [`part1.rs`](rust/src/bin/part1.rs)
- **Part 2 Solution in rust**: [`part2.rs`](rust/src/bin/part2.rs)

A Java solution may be added in the future.

---

## Prerequisites

To run these solutions, ensure you have Rust installed. You can install Rust using [rustup](https://rustup.rs/).

## How to Run

Once Rust is installed, you can run the solutions with the following commands:

```bash
cargo run --bin part1
# or
cargo run --bin part2
```