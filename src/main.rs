mod tickets;

fn is_happy_ticket(ticket: u32) -> bool {
    let digits: Vec<u32> = ticket.to_string().chars().map(|d| d.to_digit(10).unwrap()).collect();
    let half = digits.len() / 2;
    let sum_first_half: u32 = digits.iter().take(half).sum();
    let sum_second_half: u32 = digits.iter().skip(half).sum();
    sum_first_half == sum_second_half
}

fn main() {
    let mut count = 0;
    for ticket in 0..=999_999 {
        if is_happy_ticket(ticket) {
            count += 1;
        }
    }
    println!("Number of happy tickets: {}", count);
}