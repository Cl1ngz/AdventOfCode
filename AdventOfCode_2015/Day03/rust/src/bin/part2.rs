use std::collections::HashMap;
use std::fs::File;
use std::io::{self, BufRead, BufReader};

fn main() -> io::Result<()> {
    let path = "../input.txt";
    let file = File::open(path)?;
    let reader = BufReader::new(file);

    let mut robot = (0, 0);
    let mut santa = (0, 0);
    let mut houses = HashMap::new();
    houses.insert(santa, 2);

    for line in reader.lines() {
        let line = line?;

        for (i, c) in line.chars().enumerate() {
            let position = if i % 2 == 0 { &mut santa } else { &mut robot };
            match c {
                '>' => position.0 += 1,
                '^' => position.1 += 1,
                '<' => position.0 -= 1,
                'v' => position.1 -= 1,
                _ => (),
            };
            *houses.entry(*position).or_insert(0) += 1;
        }
    }
    println!("{} recive at least one present", houses.len());

    Ok(())
}
