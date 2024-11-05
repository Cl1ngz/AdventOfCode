use std::collections::HashMap;
use std::fs::File;
use std::io::{self, BufRead, BufReader};

fn main() -> io::Result<()> {
    let path = "../input.txt";
    let file = File::open(path)?;
    let reader = BufReader::new(file);

    let mut position = (0, 0);
    let mut houses = HashMap::new();
    houses.insert(position, 1);

    for line in reader.lines() {
        let line = line?;

        for c in line.chars() {
            match c {
                '>' => position.0 += 1,
                '^' => position.1 += 1,
                '<' => position.0 -= 1,
                'v' => position.1 -= 1,
                _ => (),
            };
            *houses.entry(position).or_insert(0) += 1;
        }
    }
    println!("{} houses recive at least one present", houses.len());

    Ok(())
}
