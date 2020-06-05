//100만이하의 소수의 갯수 구하기
var cnt=0;
for(var n=2;n<=1000000;n++){
	var issosu=true;
	for(var i=2;i<=Math.sqrt(n); i++){
		if(n%i==0){
			issosu=false;
			break;
		}
	}
	if(issosu){
		cnt++;
	}
}
postMessage("100만이하의 소수의 갯수:" + cnt);