# HuongSuKien-QuanLyDuLich

<h1>Phan mem quan ly cho cong ty du lich </h1>
<h3>This project source tree at this time</h3>

<b>TourManagement</b>

```bash
├───module
│   ├───iText
│   ├───bCrypt
│   ├───jDatePicker
│   └───sqlJDBC
├───res
│   ├───background
│   ├───font
│   ├───icon
│   └───logo
├───DATA
│   └───ScriptDBFull
├───src
│   ├───connect
│   ├───controllers
│   ├───DAO
│   ├───elements
│   ├───entities
│   ├───services
│   ├───utils
│   │   └───constants
│   └───view
└───ticket
```

<b><i>Please keep this format when update project.</i></b>

<h4>Please Notice</h4>
When use Date class, remember to -1900
Ex:

```java
Date example = new Date(2023 - 1900, 4, 29); //this will return 2023
```

If you don't -1900, result will be 3923 instead
<br>

<h3>Code Architecture For GUI Elements</h3>

```java
import *; //import everything here

public class className extends JFrame { // Or extends JPanel as anyway
      
      private ElementClass elementName; // Declare your Elements here

      public className() {
            // Setup
            // Set title, icon blah blah...

            // Must have
            init();
            style();
            preset();
            event();
      }

      private void init() {
            //Init Elements(JButton, JtextField,...) here
      }

      private void style() {
            // Set Color, Font or anything else
            // like you do with CSS
      }

      private void preset() {
            //Add element to JFrame, or Panel
      }

      private void event() {
            // Handle events here
            // Add event to Element
      }

      private class privateClassName { //Define more Local class here if you need

      }
}
```

<b><i>For more information, please contact Le Minh Bao</i></b>

<h5><i>Le Minh Bao</i></h5>
