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
        numStr = "0000000000" + numStr;
        length = numStr.size()
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
        for(i = 4; i <= num.toString().size(); i+=2) {
            curAns = [];
            t = numStr[length - i - 1].toInteger();
            u = numStr[length - i].toInteger();
            curAns << tensAndUnits(curAns)
            curAns << thousands[c];
            answer = curAns << tensAndUnits();
            c = c + 1
        }
        
        h = numStr[length - 3].toInteger()
        t = numStr[length - 2].toInteger()
        u = numStr[length - 1].toInteger()
        if (h > 0)
            answer << units[h] << "Hundred"
        if((u > 1 || t > 1) && h > 0)
            answer << "and"
        answer << tensAndUnits()
        answer.join(" ")
    }
}
def number = System.console().readLine 'Enter a number'
println fig2word(number.toInteger())
