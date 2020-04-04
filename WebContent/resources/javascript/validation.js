/**
 * @param event
 * @returns
 */
function checkDigit(event) {
	var keyCode = getKeyCode(event);
	if (keyCode >= 48 && keyCode <= 57) { /* Numbers */
		return true;
	} else {
		
			event.preventDefault(); // operation stop the key press
			alert('kkkkjjj');
			return false;
		
	}
	return true;
}