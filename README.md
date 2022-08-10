# smart-home-arduino-java

Procedure Part 1 [Arduino]:
==============================

1. Hardware connection
   According to .ino file
   - LED pin 4
   - LDR - pin 14
   - DHT11 pin 2
   
2. Arduino Libraries

   Name : Seeed DHT library<br>
   Why : For DHT11<br>
   From Where : [Github] https://github.com/Seeed-Studio/Grove_Temperature_And_Humidity_Sensor<br>
   How to install : https://wiki.seeedstudio.com/How_to_install_Arduino_Library/<br><br>
   
   Name : Adafruit_SSD1306<br>
   Why : I2C OLED Display <br>
   From Where : Arduino IDE > Sketch > Include Library > Manage Libraries.<br>
   How to install : Search "SSD1306"<br>
   ref: https://randomnerdtutorials.com/guide-for-oled-display-with-arduino/<br><br>
   
   Name : Adafruit_GFX<br>
   Why : I2C OLED Display <br>
   From Where : Arduino IDE > Sketch > Include Library > Manage Libraries.<br>
   How to install : Search "GFX"<br>
   ref: https://randomnerdtutorials.com/guide-for-oled-display-with-arduino/ <br><br>
   
4. Headers in arduino code

   Name: Arduino.h <br>
   Why: For arduino.<br><br>
   
   Name: DHT.h <br>
   Why: Grove - Temperature&Humidity Sensor (DHT11)<br><br>
   
   Name: Wire.h <br>
   Why: For I2C communication with ODEL Display<br><br>
   
   Name: Adafruit_GFX.h <br>
   Why: For I2C OLED Display<br><br>
   
   Name: Adafruit_SSD1306.h<br>
   Why: For I2C OLED Display<br><br>
   
5. Arduino Setup
   
   - Serial port begin at baud rate : 115200
   
3. How to run
   
   - open "<our arduino fine name here>" in arduino ide.
   - Complie the file.
   - Upload the file to Arduino board.
   - See the output in OLED display
   - Test the light sensore in low/enough light.


Appendix: 
1. Light Sensor.<br>
   ref: https://wiki.seeedstudio.com/Grove-Light_Sensor
2. LED.<br>
   ref: From class.
3. Grove - Temperature&Humidity Sensor (DHT11)<br>
   ref: https://wiki.seeedstudio.com/Grove-TemperatureAndHumidity_Sensor/
4. I2C OLED Display<br>
   ref: https://randomnerdtutorials.com/guide-for-oled-display-with-arduino/


Procedure Part 2 [Java Serial Communication]:
==================================================

1. Open provided java project in Intellij Idea.

2. Two library required: <br><br>
   Name: com.fazecast:jSerialComm:2.9.2 <br>
   Why: For serial communication with ardiono board. <br><br>
   
   Name: com.apache.commons:commons-lang3:3.3.2 <br>
   Why: To process recieved data string from arduino. <br><br>
   
   how to install:
   - go File > Project Structure > Libraries > + > From Maven > Library Name > Search & Add
   
3. Run the "MainClass.java"

4. See the output on console.

Notes:
======

1. We used Event Based Data Reading from arduino using jSerialComm. <br>
   ref: https://github.com/Fazecast/jSerialComm/wiki/Event-Based-Reading-Usage-Example

2. Our java project has three parts

	a. MainClass.java<br>
	   - Orchastrates the hole process.<br>
	   - Initiate the SerialPort.<br>
	   - Creates a "SerialPortDataListener" named DataListener.<br>
	   - add "DataListener" to SerialPort.<br>
	   
	b. DataListener.java<br>
	   - implements SerialPortDataListener.<br>
	   - ListeningEvents SerialPort.LISTENING_EVENT_DATA_RECEIVED.<br>
	   - void serialEvent() method receives the data from arduino, logs a report of current room status including Time, Light ON/OFF, Temperature & Humidity.<br>
	   
	c. SerialPortService.java<br>
	   - Opens a serialPort with boud rate 115200, 8 bit byte size, stop bit 1 and no parity.

Appendix: 
1. jSeialComm<br>
   ref: https://fazecast.github.io/jSerialComm/
2. Event Based Data Reading from arduino using jSerialComm<br>
   ref: https://github.com/Fazecast/jSerialComm/wiki/Event-Based-Reading-Usage-Example
