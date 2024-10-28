use std::cmp::min;
use std::fs::File;
use std::io::{self, BufRead, BufReader};

fn main() -> io::Result<()> {
    let path = "../input.txt";
    let file = File::open(path)?;
    let reader = BufReader::new(file);

    let mut ribbon = 0;

    for line in reader.lines() {
        let dims: Vec<u32> = line?
            .split('x')
            .filter_map(|x| x.parse::<u32>().ok())
            .collect();

        let l = dims[0];
        let w = dims[1];
        let h = dims[2];
        let lw = 2 * (l + w);
        let wh = 2 * (w + h);
        let hl = 2 * (h + l);

        let extra = min(lw, min(wh, hl));

        ribbon += l * w * h + extra;
    }
    println!("Amount of ribbon in feet they need to order: {}", ribbon);

    Ok(())
}
