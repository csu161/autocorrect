# autocorrect
First assignment, exercises use of strings, arrays, file i/o.

The big picture is it will take a string and return an array of words from the dictionary that are the most likely matches for an autocorrecter. Specifically it will return the lowest "scoring" words of the same length. The score is the maximum distance between two corresponding letters from the original string and the candidate word. Distance between letters is calculated from the x-y coordinates of the keys representing those letters on an iPhone keyboard. These coordinates are recorded in the keyCoordinates.txt file.

## Example distance calculation
Our input string is "abc" and the dictionary word we are comparing to is "end".
  * To calculate the letter distances:
    * a is (127, 259), e is (310, 91)
    * the distance between these points is sqrt((127-310)^2 + (259-91)^2) which is roughly 248.421
    * b is (744, 428), n is (866, 428)
    * the distance between these points is 122
    * c is (498, 428), d is (374, 259)
    * the distance between these points is roughly 209.61
  * The score for "end" is the largest of these distances, roughly 248.421

## Start here
You only need to change MinMaxDistCorrecter.java unless you want to implement some of your code in other files or create your own abstractions. IAutocorrect.java is the interface your class must implement. KeyMap.java is a helper class to manage your key coordinates, it's use is not required. KeepLowestScored.java is a helper class to manage your lowest scoring dictionary words, it's use is not required.

There are two files your program will need to read and parse, the dictionary and the key coordinates file.


```bash
$ java TestAutocorrect words2.txt keyCoordinates.txt
dog
[dog, sog, dig, sig, fig, fog, soh, div, sov, rig, rog, foy, Roy, sky, soy, Spy, spy, dit, Dot, dot]
denver
[fencer, dennet, rennet, sennet, zehner, cabber, camber, cancer, canned, canner, cannet, canvas, dabber, damned, damner, dancer, danger, danner, fanged, fanner]
call
[call, vall, calk, fall, calp, gall, galp, gaol, gapo, dalk, calm, camp, damp, gamp, vamp, balk, ball, balm, bell, cell]
me
[me, Mr, ne, be, ba, ka, la, Ma, ma, na, ha, he, Od, od, oe, of, or, Os, os, ow]
ishmael
[Ishmael, kenmark, hauberk, primero, oatmeal, ostmark, Paumari, jayhawk, Kachari, Lambadi, oscheal, oxcheek, haikwan, jackeen, Lethean, nagmaal, nainsel, nankeen, magneto, makhzan]
qwerty
[assert, artery, eatery, wadset, watery, wedset, astrut, asteer, astrer, awater, Easter, easter, eraser, ewerer, wadder, warder, warrer, waster, wearer, weaser]
accident
[accident, addicent, adducent, abducent, abdicant, accusant, affidavy, excitant, assident, assurant, essorant, absurdly, actively, astutely, athletic, estivage, ethidene, schistic, schiztic, abristle]
abcdefg  
[ambassy, ambatch, embassy, encraty, endarch, engraff, engraft, acceder, angster, ecstasy, engreen, enheart, aftward, anteact, enterer, augerer, autarch, duddery, duftery, duvetyn]
```
