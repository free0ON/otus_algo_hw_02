mod tickets;

use tickets::brut_get_happy_count;
use tickets::fast_get_happy_count;


fn main() {
    for i in 1..=5
    {
        println!("Brut count: {} {}",i, brut_get_happy_count(i));    
    }

    for i in 1..=10
    {
        println!("Fast count: {} {}",i, fast_get_happy_count(i));    
    }

}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn brut_tickets_test()
    {
        let out:[u64; 5] = [10, 670, 55252, 4816030, 432457640];
        let mut count:u64 = 0;
        let mut i: u32 = 1;
        for count_out in out
        {
            count = brut_get_happy_count(i);
            println!("Brut count: {} {}",count_out, count);    
            assert_eq!(count, count_out);
            i += 1;
        }
    }
    #[test]
    fn fast_tickets_test()
    {
        let out:[u64; 10] = [10, 670, 55252, 4816030, 432457640, 39581170420, 3671331273480, 343900019857310, 32458256583753952, 3081918923741896840];
        let mut count:u64 = 0;
        let mut i: u32 = 1;
        for count_out in out
        {
            count = fast_get_happy_count(i);
            println!("Fast count: {} {}",i, count);    
            assert_eq!(count, count_out);
            i += 1;
        }
    }

}