function frontOnDutyToday(){
   var dutyData= 
	[
	  ['星期一','局领导1','值班长1','接警员1'],
	  ['星期二','局领导2','值班长2','接警员2'],
	  ['星期三','局领导3','值班长3','接警员3'],
	  ['星期四','局领导4','值班长4','接警员4'],
	  ['星期五','局领导5','值班长5','接警员5'],
	  ['星期六','局领导6','值班长6','接警员6'],
	  ['星期日','局领导7','值班长7','接警员7'],
	];
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
