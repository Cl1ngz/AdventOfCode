use itertools::Itertools;
use std::fs::File;
use std::io::{self, BufRead, BufReader};

fn is_nice(s: &str) -> bool {
    // At least three vowels
    let vowels = "aeiou";
    let vowel_count = s.chars().filter(|&c| vowels.contains(c)).count();
    if vowel_count < 3 {
        return false;
    }

    // At least one double letter
    if !s.chars().tuple_windows().any(|(a, b)| a == b) {
        return false;
    }

    // No forbidden substrings
    let forbidden = ["ab", "cd", "pq", "xy"];
    for &f in &forbidden {
        if s.contains(f) {
            return false;
        }
    }

    true
}

fn main() -> io::Result<()> {
    let path = "../input.txt";
    let file = File::open(path)?;
    let reader = BufReader::new(file);

    // let nice_count = reader
    //     .lines()
    //     .filter_map(|line| line.ok())
    //     .filter(|line| is_nice(line))
    //     .count();

    let nice_count = reader
        .lines() // This produces an iterator over Result<String, io::Error>
        .filter_map(|line| match line {
            Ok(l) => Some(l), // If line is Ok, continue
            Err(e) => {
                eprintln!("Error reading line: {}", e);
                None
            }
        })
        .filter(|line| is_nice(line)) // Filter nice strings
        .count(); // Count how many nice strings there are

    println!("Number of nice strings: {}", nice_count);

    Ok(())
}
