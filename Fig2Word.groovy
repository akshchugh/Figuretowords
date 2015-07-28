def fig2word(int num) {
    def units = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"]
    def teens = ["","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
                 "Eighteen","Nineteen"]
    def tens = ["","Ten","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", 
                "Ninety"]
    def thousands = ["", "Thousand","Lakh","Crore"]
    if (num==0)
        "Zero"
    else {
        def answer = []
        numStr = num.toString()
        origSize = num.toString().size()
        numStr = "0000000000" + numStr;
        length = numStr.size()
       
        c = 1
        for(i = 4; i <= origSize; i+=2) {
            curAns = [];
            t = numStr[length - i - 1].toInteger();
            u = numStr[length - i].toInteger();
             if (t > 1) {
                curAns << tens[t]
                if(u >= 1) curAns << units[u]
            }
            else if(t == 1){
                if(u >= 1) curAns << teens[u]
                else curAns << tens[t]
            }
            else {
                if(u >= 1) curAns << units[u]
            }
            curAns << thousands[c];
            answer = curAns + answer;
            c = c + 1
        }
        
        h = numStr[length - 3].toInteger()
        t = numStr[length - 2].toInteger()
        u = numStr[length - 1].toInteger()
        if (h > 0)
            answer << units[h] << "Hundred"
        if((u > 1 || t > 1) && h > 0)
            answer << "and"
        if (t > 1) {
            answer << tens[t]
            if(u >= 1) answer << units[u]
        }
        else if(t == 1){
            if(u >= 1) answer << teens[u]
            else answer << tens[t]
        }
        else {
            if(u >= 1) answer << units[u]
        }
        answer.join(" ")
    }
}
def number = System.console().readLine 'Enter a number'
println fig2word(number.toInteger())
