use std::fs;
use std::io;

fn main() -> io::Result<()> {
    // println!("Current working directory: {:?}", env::current_dir()?);
    let path = "../input.txt";
    let data = fs::read_to_string(path)?;

    let up = data.matches('(').count();
    let down = data.matches(')').count();
    println!("{}", up - down);

    Ok(())
}
