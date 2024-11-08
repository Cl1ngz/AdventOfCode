use std::fs::File;
use std::io::{self, BufRead, BufReader};

enum Instruction {
    TurnOn,
    TurnOff,
    Toggle,
}

fn parse_instruction(line: &str) -> (Instruction, (usize, usize), (usize, usize)) {
    let inst: Vec<&str> = line.split_whitespace().collect();
    let (action, start, end) = match inst[0] {
        "toggle" => (Instruction::Toggle, inst[1], inst[3]),
        "turn" if inst[1] == "on" => (Instruction::TurnOn, inst[2], inst[4]),
        "turn" if inst[1] == "off" => (Instruction::TurnOff, inst[2], inst[4]),
        _ => panic!("Unknow istr"),
    };

    let start_coords = start.split(',').collect::<Vec<&str>>();
    let end_coords = end.split(',').collect::<Vec<&str>>();

    (
        action,
        (
            start_coords[0].parse().unwrap(),
            start_coords[1].parse().unwrap(),
        ),
        (
            end_coords[0].parse().unwrap(),
            end_coords[1].parse().unwrap(),
        ),
    )
}

fn apply_instruction(
    grid: &mut [[bool; 1000]; 1000],
    instr: Instruction,
    start: (usize, usize),
    end: (usize, usize),
) {
    for x in start.0..=end.0 {
        for y in start.1..=end.1 {
            match instr {
                Instruction::TurnOn => grid[x][y] = true,
                Instruction::TurnOff => grid[x][y] = false,
                Instruction::Toggle => grid[x][y] = !grid[x][y],
            }
        }
    }
}

fn main() -> io::Result<()> {
    let path = "../input.txt";
    let file = File::open(path)?;
    let reader = BufReader::new(file);

    let mut grid = [[false; 1000]; 1000];

    for line in reader.lines() {
        let line = line?;
        let (instruction, start, end) = parse_instruction(&line);
        apply_instruction(&mut grid, instruction, start, end);
    }

    let lit_count = grid.iter().flatten().filter(|&&light| light).count();
    println!("Number of lights that are on: {}", lit_count);
    Ok(())
}
