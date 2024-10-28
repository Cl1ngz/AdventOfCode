use std::cmp::min;
use std::fs::File;
use std::io::{self, BufRead, BufReader};

fn main() -> io::Result<()> {
    let path = "../input.txt";
    let file = File::open(path)?;
    let reader = BufReader::new(file);

    let mut total = 0;

    for line in reader.lines() {
        let dims: Vec<u32> = line?
            .split('x')
            .filter_map(|x| x.parse::<u32>().ok())
            .collect();

        let l = dims[0];
        let w = dims[1];
        let h = dims[2];
        let lw = l * w;
        let wh = w * h;
        let hl = h * l;

        let extra = min(lw, min(wh, hl));

        total += (2 * lw) + (2 * wh) + (2 * hl) + extra;
    }
    println!("They need to order {} square feet of wrapping paper", total);

    Ok(())
}
