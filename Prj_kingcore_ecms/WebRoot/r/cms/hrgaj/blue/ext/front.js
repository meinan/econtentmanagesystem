function frontOnDutyToday(){
   var dutyData = Data_OnDuty;
	var week = weekday();
	//alert(week);
	for(var i=0; i<dutyData.length; i++){
		if(dutyData[i][0]==week){
	   		return "<font color='red'><B>今日值班</B>  局领导：</font>"+dutyData[i][1]
	   		            +"  <font color='red'>值班长：</font>"+dutyData[i][2]
	   		            +"  <font color='red'>接警员：</font>"+dutyData[i][3];
		}
	}
}
