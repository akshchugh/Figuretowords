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
		String answer = ""
		length = num.toString().size()
		h = (num\\100)%10;
		t = (num\\10)%10;
		u = num%10;
		if (h > 0)
			answer+= units[h] + " hundred"
		if (t > 1) {
			answer += tens[t]
			if(u >= 1)
				answer += " " + units[u]
		}
		else if(t == 1){
			if(u >= 1) answer += teens[u]
			else answer += tens[t]
		}
		else {
			if(u >= 1) answer += units[u]
		}
		println answer
	}
	"Six hundred"
}
def x = 1234
println fig2word(x)