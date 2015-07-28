def fig2word(Integer num) {
    units = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"]
    teens = ["","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
                 "Eighteen","Nineteen"]
    tens = ["","Ten","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", 
                "Ninety"]
    thousands = ["", "Thousand","Lakh","Crore"]
    if (num==0)
        "Zero"
    else {
        answer = []
        numStr = ("0000000000" + num.toString()).reverse()
        def tensAndUnits = {
            ans = []
            if (t > 1) {
                ans << tens[t]
                if(u >= 1) ans << units[u]
            }
            else if(t == 1){
                if(u >= 1) ans << teens[u]
                else ans << tens[t]
            }
            else {
                if(u >= 1) ans << units[u]
            }
            ans
        }
       
        c = 1
        for(i = 3; i < num.toString().size(); i+=2) {
            curAns = [];
            t = numStr[i + 1].toInteger();
            u = numStr[i].toInteger();
            curAns << tensAndUnits()
            if(t > 0 || u > 0) curAns << thousands[c];
            answer = curAns + answer;
            c = c + 1
        }
        numStr = numStr.reverse()
        length = numStr.size()
        h = numStr[length - 3].toInteger()
        t = numStr[length - 2].toInteger()
        u = numStr[length - 1].toInteger()
        if (h > 0)
            answer << units[h] << "Hundred"
        if((u >= 1 || t >= 1) && (h > 0||num >= 1000))
            answer << "and"
        answer << tensAndUnits()
        answer.flatten().join(" ")
    }
}

assert (fig2word(600)) == "Six Hundred"
assert (fig2word(2001)) == "Two Thousand and One"
assert (fig2word(10)) == "Ten"
assert (fig2word(29)) == "Twenty Nine"
assert (fig2word(2500)) == "Two Thousand Five Hundred"
assert (fig2word(100101)) == "One Lakh One Hundred and One"

def number = System.console().readLine 'Enter a number'
println fig2word(number.toInteger())
