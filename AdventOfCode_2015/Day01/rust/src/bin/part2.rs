use std::fs;
use std::io;

fn main() -> io::Result<()> {
    let path = "../input.txt";
    let data = fs::read_to_string(path)?;

    let mut total: i32 = 0;
    for (index, a) in data.chars().enumerate() {
        match a {
            '(' => total += 1,
            ')' => total -= 1,
            _ => (), // Ignore any other characters
        };

        if total == -1 {
            println!("{}", index + 1); // +1 because we start from 1
            break;
        }
    }
    Ok(())
}
