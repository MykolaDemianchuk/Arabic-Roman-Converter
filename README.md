# Arabic-Roman-Converter
Java application for Arabic-Roman and Roman-Arabic numeral conversion. <br>

## Installing
To launch the app simlpy download executable jar file - target/<b>ArabicRomanConverter-1.3.jar.</b>

## Preview 

Starting point is a <a href="https://github.com/MykolaDemianchuk/ArabicRomanConverter-Maven#rules">rules</a> reminder:

![screenshot-3](https://user-images.githubusercontent.com/35743439/38646299-ffa891ce-3dac-11e8-8dd8-ca5233bb075f.png)

Input is case insensitive, trimmed from both ends:

![screenshot-1](https://user-images.githubusercontent.com/35743439/38645945-9d2531fc-3dab-11e8-8115-121f12643bf8.png)

In case of violation of <a href="https://github.com/MykolaDemianchuk/ArabicRomanConverter-Maven#rules">rules</a> or typo you'll get an error message:
![screenshot-2](https://user-images.githubusercontent.com/35743439/38645953-a67d2d54-3dab-11e8-956f-8513bdb1e84d.png)


## Rules
Roman numerals are based on the following symbols:
<table>
    <tr>
        <th>Symbol</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>I</td>
        <td>1</td>
    </tr>
    <tr>
        <td>V</td>
        <td>5</td>
    </tr>
    <tr>
        <td>X</td>
        <td>10</td>
    </tr>
    <tr>
        <td>L</td>
        <td>50</td>
    </tr>
    <tr>
        <td>C</td>
        <td>100</td>
    </tr>
    <tr>
        <td>D</td>
        <td>500</td>
    </tr>
    <tr>
        <td>M</td>
        <td>1000</td>
    </tr>
</table>

### Rule #1
Only the digits I, X, C and M can be repeated up to three times.

<b>Example:</b>
          <table>
          <tr>
            <th>Legal</th> 
            <th>Illegal</th>
         </tr>
         <tr>
            <td>MMM</td> 
            <td>CCCC</td>
         </tr>
         <tr>
            <td>CCC</td> 
            <td>IIII</td>
         </tr>
         <tr>
            <td>II</td> 
            <td>VV</td>
         </tr>
         </table>


### Rule #2 
When a digit of lower value is written to the right or after a digit of higher value, then the values of all digits are added.

<b>Example:</b>
        <table><tr>
            <th>CCXXX</th> <td>C + C + X + X + X</td> <td>100 + 100 + 10 + 10 + 10</td>
         </tr><tr>
            <th>MMXIII</th> <td>M + M + X + I + I + I</td> <td>1000 + 1000 + 100 + 1 + 1 + 1</td>
         </tr></table>

### Rule #3 
When a digit of lower value is written to the left or before a digit of higher value, then the value of the lower digit is subtracted from the value of the higher digit.

<b>Example:</b> 
          <table><tr>
            <th>XXIV</th> <td>X + X + |I - V|</td> <td>10 + 10 + 4</td>
         </tr><tr>
            <th>CMXLIX</th> <td>|C - M| + |X - L| + |I - X|</td> <td>900 + 40 + 9</td>
         </tr></table>
