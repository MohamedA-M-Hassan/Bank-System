function checkDigit(event) {
		
		var keyCode = event.charCode;
		if (keyCode >= 48   && keyCode <= 57) { /* Numbers */
			
				 return true;
			
		} else {
			if (!SpecialOperations(event)) { // check if special operation
				alert('Please enter vaild number!');
				event.preventDefault(); // operation stop the key press
				
				return false;
			}
		}
		return true;
	}



function SpecialOperations(event) {
	var keyCode = event.charCode;
	if (event.ctrlKey === true
			&& (keyCode == 97 || keyCode == 99 || keyCode == 118)) {
		return true;
	}
	return false;
}
