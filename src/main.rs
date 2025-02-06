mod tickets;

use tickets::get_happy_count;

fn main() {
    for i in 5..=5
    {
        println!("Number of happy tickets: {} {}",i, get_happy_count(i));    
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn BrutTicketsTest()
    {
        let out:[u64; 5] = [10, 670, 55252, 4816030, 39581170420];
        let mut count:u64 = 0;
        let mut i: u32 = 1;
        for count_out in out
        {
            count = get_happy_count(i);
            println!("Number of happy tickets: {} {}",i, count);    
            assert_eq!(count, count_out);
            i += 1;
        }
    }
}