function frontOnDutyToday(){
   var dutyData = Data_OnDuty;
	var week = weekday();
	//alert(week);
	for(var i=0; i<dutyData.length; i++){
		if(dutyData[i][0]==week){
	   		return "今日值班  局领导："+dutyData[i][1]
	   		            +"  值班长："+dutyData[i][2]
	   		            +"  接警员："+dutyData[i][3];
		}
	}
}
