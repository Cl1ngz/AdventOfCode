use itertools::Itertools;
use std::fs::File;
use std::io::{self, BufRead, BufReader};

fn contains_non_overlapping_pair(s: &str) -> bool {
    for i in 0..s.len() - 1 {
        for j in i + 2..s.len() - 1 {
            if s[i..i + 2] == s[j..j + 2] {
                return true;
            }
        }
    }
    false
}

fn contains_repeat_with_one_between(s: &str) -> bool {
    s.chars().tuple_windows().any(|(a, _, c)| a == c)
}

fn is_nice(s: &str) -> bool {
    contains_repeat_with_one_between(s) && contains_non_overlapping_pair(s)
}

fn main() -> io::Result<()> {
    let path = "../input.txt";
    let file = File::open(path)?;
    let reader = BufReader::new(file);

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
