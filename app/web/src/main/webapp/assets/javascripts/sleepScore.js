/**
 * 计算嗜睡表总分数
 */
function sumSleep(sleepWhenRead, sleepWhenWatchTv, sleepWhenPublicPlace,
		sleepInCar, sleepWhenAfternoon, sleepWhenTalk, sleepAfterLunch,
		sleepWhenBusyTraffic) {
	// 嗜睡表总积分变化
	var sleepScore = 0;
	var isHas = false;
	if (!isNaN(parseInt(sleepWhenRead))) {
		sleepScore = sleepScore + parseInt(sleepWhenRead);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepWhenWatchTv))) {
		sleepScore = sleepScore + parseInt(sleepWhenWatchTv);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepWhenPublicPlace))) {
		sleepScore = sleepScore + parseInt(sleepWhenPublicPlace);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepInCar))) {
		sleepScore = sleepScore + parseInt(sleepInCar);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepWhenAfternoon))) {
		sleepScore = sleepScore + parseInt(sleepWhenAfternoon);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepWhenTalk))) {
		sleepScore = sleepScore + parseInt(sleepWhenTalk);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepAfterLunch))) {
		sleepScore = sleepScore + parseInt(sleepAfterLunch);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepWhenBusyTraffic))) {
		sleepScore = sleepScore + parseInt(sleepWhenBusyTraffic);
		isHas = true;
	}
	if (isHas) {
		$("#isSleepShow").show();
		$("#sleepScore").text(sleepScore);
		if (sleepScore >= 0 && sleepScore <= 5) {
			$("#sleepLevel").text("健康");
		} else if (sleepScore >= 6 && sleepScore <= 10) {
			$("#sleepLevel").text("瞌睡");
		} else if (sleepScore >= 11 && sleepScore <= 15) {
			$("#sleepLevel").text("过度瞌睡");
		} else if (sleepScore >= 16) {
			$("#sleepLevel").text("有危险性的瞌睡");
		}
	}
}

/**
 * 计算嗜睡表总分数
 */
function sumSleepTotal(sleepWhenRead, sleepWhenWatchTv, sleepWhenPublicPlace,
		sleepInCar, sleepWhenAfternoon, sleepWhenTalk, sleepAfterLunch,
		sleepWhenBusyTraffic) {
	// 嗜睡表总积分变化
	var sleepScore = 0;
	var isHas = false;
	if (!isNaN(parseInt(sleepWhenRead))) {
		sleepScore = sleepScore + parseInt(sleepWhenRead);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepWhenWatchTv))) {
		sleepScore = sleepScore + parseInt(sleepWhenWatchTv);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepWhenPublicPlace))) {
		sleepScore = sleepScore + parseInt(sleepWhenPublicPlace);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepInCar))) {
		sleepScore = sleepScore + parseInt(sleepInCar);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepWhenAfternoon))) {
		sleepScore = sleepScore + parseInt(sleepWhenAfternoon);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepWhenTalk))) {
		sleepScore = sleepScore + parseInt(sleepWhenTalk);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepAfterLunch))) {
		sleepScore = sleepScore + parseInt(sleepAfterLunch);
		isHas = true;
	}
	if (!isNaN(parseInt(sleepWhenBusyTraffic))) {
		sleepScore = sleepScore + parseInt(sleepWhenBusyTraffic);
		isHas = true;
	}
	var scoreArray= new Array();;
	scoreArray[0]=isHas;
	scoreArray[1]=sleepScore;
	if (sleepScore >= 0 && sleepScore <= 5) {
		scoreArray[2]="健康";
	} else if (sleepScore >= 6 && sleepScore <= 10) {
		scoreArray[2]="瞌睡";
	} else if (sleepScore >= 11 && sleepScore <= 15) {
		scoreArray[2]="过度瞌睡";
	} else if (sleepScore >= 16) {
		scoreArray[2]="有危险性的瞌睡";
	}
	return scoreArray;
}
