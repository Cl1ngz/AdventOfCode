use md5::{Digest, Md5};
fn main() {
    // let secret_key = "abcdef";
    let secret_key = "ckczppom";
    let mut number = 1; // brutforcing addind one to scretkey until it starts with 0000

    loop {
        let input = format!("{}{}", secret_key, number);

        let mut hasher = Md5::new();
        hasher.update(input.as_bytes());
        let result = hasher.finalize();

        let hex_string = format!("{:x}", result);

        if hex_string.starts_with("00000") {
            println!("The lowest number is: {}", number);
            break;
        }

        number += 1;
    }
}
