var stringArray1 = " ";
var stringArray2 = " ";

var interval = 120
var spacelen = 120;
var space10 = " ";
var seq = 0;
var t;

function getspeak(words) {
	stringArray1 = words;
	speak();

	document.getElementById("button").style.display = 'none';
	document.getElementById("speak").style.display = 'block';
	document.getElementById("speak_back").style.display = 'block';
	document.getElementById("head").style.display = 'block';
}
function speak() {

	len = stringArray1.length;
	if (seq <= len) {
		document.getElementById("speak").innerHTML += stringArray1.substring(
				seq, seq + 1);
		seq++;
		t = setTimeout("speak()", 120);
	} else {
		seq = 0;
		clearTimeout(t);
		getspeak(" ");
	}
	// document.write(" <div
	// style='position:absolute;left:60px;top:20px;width:142px;height:165px;background-color:#F6F6F6;'
	// >");
	// document.write("</div>");
	// document.getElementById("speak").innerHTML+='<div id=ke
	// style=\"position:absolute;'+
	// 'left:50px; Top:100px; width:500px; height:120px; z-index:1;
	// display:none;'+
	// 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=speak.png,
	// sizingMethod=scale); \" ></div>';
}

var myTime;
var per_x = 100; 
var per_y = 300;
var walk_id = 1;
var speed = 150;
var point=1;
var map = new Array(24);

function init() {

}
var y_pos;
var x_pos;

document.onmousedown = function walk() {
	x_pos = event.x;
	y_pos = event.y;
	$("#a").val(x_pos);
	$("#b").val(y_pos);
	if (event.x < 640 && event.y < 480){
		var pTop=$('#person').position().top;
		$("#c").val(pTop);
		var pLeft=$('#person').position().left;
		$("#d").val(pLeft);
		if (pTop == 0 && pLeft == 0) {
			$('#person').css("top",x_pos);
			$('#person').css("left",y_pos);
		}

		if (y_pos<pTop && x_pos>pLeft && x_pos < pLeft+80) {
			up(y_pos);
		} else if (y_pos>pTop && x_pos>pLeft && x_pos< pLeft+80) {
			down(y_pos);
		} else if (x_pos>pLeft && y_pos>pTop && y_pos<pTop + 80) {
			right();
		} else if (x_pos<pLeft && y_pos>pTop && y_pos<pTop + 80) {
			left(x_pos);
		} else if (x_pos>pLeft && y_pos<pTop) {
			right_up();
		} else if (x_pos>pLeft && y_pos>pTop) {
			right_down();
		} else if (x_pos<pLeft && y_pos>pTop) {
			left_down();
		} else if (x_pos<pLeft && y_pos<pTop) {
			left_up();
		}
	}

}

document.onmouseup = function stop() {
	clearTimeout(myTime);
	var imgUrl = "../img/0-" + point + ".png";
	$('#person').css("background-image","url(" + imgUrl + ")"); 
}

//up
function up(y_pos) {
	var pTop=$('#person').position().top;
	if ((pTop + 80) <= y_pos) {
		stop();
	}
	else {
		if (walk_id == 4) {
			walk_id = 1;
		} else {
			walk_id++;
		}
		var imgUrl = "../img/1-" + walk_id + ".png";
		$('#person').css("top",pTop-20); 
		$('#person').css("background-image","url(" + imgUrl + ")"); 
		point = 1;
		myTime = setTimeout('up()', speed);
	}
}

// down
function down(y_pos) {
	var pTop=$('#person').position().top;
	if ((pTop + 80) >= y_pos) {
		stop();
	} else {
		if (walk_id == 4) {
			walk_id = 1;
		} else {
			walk_id++;
		}
		var imgUrl = "../img/5-" + walk_id + ".png";
		$('#person').css("top",pTop+20); 
		$('#person').css("background-image","url(" + imgUrl + ")"); 
		point = 5;
		myTime = setTimeout('down()', speed);
	}

}

//left
function left(x_pos) {
	var pLeft=$('#person').position().left;
	if (pLeft <= 0) {
		stop();
	} else {
		if (walk_id == 4) {
			walk_id = 1;
		} else {
			walk_id++;
		}
		var imgUrl = "../img/7-" + walk_id + ".png";
		$('#person').css("left",pLeft-20); 
		$('#person').css("background-image","url(" + imgUrl + ")"); 
		point = 7;
		myTime = setTimeout('left()', speed);
	}
}

//right
function right(x_pos) {
	var pLeft=$('#person').position().left;
	if (pLeft >= 600) {
		stop();
	} else {
		if (walk_id == 4) {
			walk_id = 1;
		} else {
			walk_id++;
		}
		var imgUrl = "../img/3-" + walk_id + ".png";
		$('#person').css("left",pLeft+20); 
		$('#person').css("background-image","url(" + imgUrl + ")"); 
		point = 3;
		myTime = setTimeout('right()', speed);
	}
}

// left_up
function left_up(x_pos,y_pos) {
	var pLeft=$('#person').position().left;
	var pTop=$('#person').position().top;
	if (pLeft <=0) {
		stop();
	} else if(pTop <=0){
		stop();
	}else {
		if (walk_id == 4) {
			walk_id = 1;
		} else {
			walk_id++;
		}
		var imgUrl = "../img/8-" + walk_id + ".png";
		$('#person').css("left",pLeft-20); 
		$('#person').css("top",pTop-20);
		$('#person').css("background-image","url(" + imgUrl + ")"); 
		point = 8;
		myTime = setTimeout('left_up()', speed);
	}
}

// right_up
function right_up(x_pos,y_pos) {

	if (document.getElementById('person').style.pixelTop <= 0) {
		document.getElementById('person').style.pixelTop = 0;
		stop();
	}

	else if (document.getElementById('person').style.pixelLeft >= 560) {
		document.getElementById('person').style.pixelLeft = 560;
		stop();
	} else {
		document.getElementById('person').style.pixelLeft += 20;
		document.getElementById('person').style.pixelTop -= 20;
		if (walk_id == 4) {
			walk_id = 1;
		} else {
			walk_id++;
		}
		document.getElementById('person').style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src=2-"
				+ walk_id + ".png', sizingMethod='scale')";
		point = 2;

		var x1 = (document.getElementById('person').style.pixelTop + 80) / 20;
		var y1 = document.getElementById('person').style.pixelLeft / 20;
		if (map[x1][y1 + 1] == 1 || map[x1][y1 + 2] == 1) {
			document.getElementById('person').style.pixelTop += 20;
			document.getElementById('person').style.pixelLeft -= 20;
			stop();
		}
		myTime = setTimeout('right_up()', speed);
	}
}

// left_down
function left_down(x_pos,y_pos) {

	if (document.getElementById('person').style.pixelTop >= 380) {
		document.getElementById('person').style.pixelTop = 400;
		stop();
	}

	else if (document.getElementById('person').style.pixelLeft < 0) {
		document.getElementById('person').style.pixelLeft = 0;
		stop();
	} else {
		document.getElementById('person').style.pixelLeft -= 20;
		document.getElementById('person').style.pixelTop += 20;
		if (walk_id == 4) {
			walk_id = 1;
		} else {
			walk_id++;
		}
		document.getElementById('person').style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src=6-"
				+ walk_id + ".png', sizingMethod='scale')";
		point = 6;
		var x1 = (document.getElementById('person').style.pixelTop + 80) / 20;
		var y1 = document.getElementById('person').style.pixelLeft / 20;

		if (map[x1][y1 + 1] == 1 || map[x1][y1 + 2] == 1) {
			document.getElementById('person').style.pixelTop -= 20;
			document.getElementById('person').style.pixelLeft += 20;
			stop();
		}
		myTime = setTimeout('left_down()', speed);
	}
}

// right_down
function right_down(x_pos,y_pos) {

	if (document.getElementById('person').style.pixelTop >= 400) {
		document.getElementById('person').style.pixelTop = 400;
		stop();
	}

	else if (document.getElementById('person').style.pixelLeft >= 560) {
		document.getElementById('person').style.pixelLeft = 560;
		stop();
	} else {
		document.getElementById('person').style.pixelLeft += 20;
		document.getElementById('person').style.pixelTop += 20;
		if (walk_id == 4) {
			walk_id = 1;
		} else {
			walk_id++;
		}
		document.getElementById('person').style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src=4-"
				+ walk_id + ".png', sizingMethod='scale')";
		point = 4;
		var x1 = (document.getElementById('person').style.pixelTop + 80) / 20;
		var y1 = document.getElementById('person').style.pixelLeft / 20;

		if (map[x1][y1 + 1] == 1 || map[x1][y1 + 2] == 1) {
			document.getElementById('person').style.pixelTop -= 20;
			document.getElementById('person').style.pixelLeft -= 20;
			stop();
		}
		myTime = setTimeout('right_down()', speed);
	}
}