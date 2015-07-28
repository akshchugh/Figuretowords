def figuretoword(Integer number) {
    units = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"]
    teens = ["","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
                 "Eighteen","Nineteen"]
    tens = ["","Ten","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", 
                "Ninety"]
    thousands = ["", "Thousand","Lakh","Crore"]
    if ( number == 0 )
        "Zero"

    else {
        wordString = []
        numberString = ("0000000000" + number.toString()).reverse()
        
        def tensAndUnits = {
            ansString = []
            if (tensDigit > 1) {
                ansString << tens[t]
                if (u >= 1) ansString << units[u]
            } else if (tensDigit == 1) {
                if (unitDigit >= 1) ansString << teens[u]
                else ansString << tens[t]
            } else {
                if (unitDigit >= 1) ansString << units[u]
            }

            ansString
        }
       
        c = 1
        for(index = 3; index < number.toString().size(); index += 2) {
            currenAnsString = [];
            tensDigit = numberString[i + 1].toInteger();
            unitDigit = numberString[i].toInteger();
            currentAnsString << tensAndUnits()
            if(tensDigit > 0 || unitDigit > 0) currentAnsString << thousands[c];
            
            wordString = currentAnsString + wordString;
            c = c + 1
        }
        numberString = numberString.reverse()
        length = numberString.size()
        hundredDigit = numberString[length - 3].toInteger()
        tensDigit = numberString[length - 2].toInteger()
        unitDigit = numberString[length - 1].toInteger()
        if (hundredDigit > 0)
            
        wordString << units[h] << "Hundred"
        if((unitDigit >= 1 || tensDigit >= 1) && (hundredDigit > 0||number >= 1000))
            
        wordString << "and"
        wordString << tensAndUnits()
        wordString.flatten().join(" ")
    }
}

assert (figuretoword(600)) == "Six Hundred"
assert (figuretoword(2001)) == "Two Thousand and One"
assert (figuretoword(10)) == "Ten"
assert (figuretoword(29)) == "Twenty Nine"
assert (figuretoword(2500)) == "Two Thousand Five Hundred"
assert (figuretoword(100101)) == "One Lakh One Hundred and One"

def number = System.console().readLine 'Enter a number'
println figuretoword(number.toInteger())
