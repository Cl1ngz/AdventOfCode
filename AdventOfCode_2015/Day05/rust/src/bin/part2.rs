use std::fs::File;
use std::io::{self, BufRead, BufReader};

fn main() -> io::Result<()> {
    let path = "../input.txt";
    let file = File::open(path)?;
    let reader = BufReader::new(file);

    Ok(())
}
