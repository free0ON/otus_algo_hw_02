fn get_sum_number(_number: u64, n: u32) -> u64
    {
        let mut sum: u64 = 0;
        let mut number: u64 = _number;
        for _i in 0..=n
        {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

pub fn get_happy_count(n: u32) -> u64
{
        let mut count: u64 = 0;
        let max_num: u64 = u64::pow(10,n);
        for left in 0..max_num
        {
            for right in 0..max_num
            {
                if get_sum_number(left, n) == get_sum_number(right, n)  
                {
                    count += 1;
                }
            }
        }
    return count;
}