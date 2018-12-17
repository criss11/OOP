IVANOV CRISTINA
323 CD

Ideea in jurul careia se bazeaza codul meu a fost accesarea usoara a tuturor jucatorilor de oriunde din cod, 
astfel primul pas a fost crearea unui obiect de tip PlayersData in care se stocheaza o lista cu toti jucatorii,
plus pachetul de carti nefolosite inca. Fiecare jucator este de tip Strategy si contine toate campurile care
definesc jucatorul respectiv, de la cartile pe care le are pe stand pana la mita pe care o ofera intr-o runda.
Din main se apeleaza metoda play a clasei Rounds, unde se desfasoara jocul in sine, in 4 etape descrise
si in cod: impartirea cartilor, declararea bunurilor, controlul sherifului, punerea bunurilor respective pe taraba.
Declare-ul de baza este scris in Strategy, iar declare-urile specifice fiecarui jucator sunt suprascrise in clasele
derivate. Asemenea si in cazul sherifului(metoda basic sheriff in strategy, pe cand strategia lui greedy este
suprascrisa in greedyStrategy). 
La finalul rundelor, printez scorul in metoda print a clasei PrintScore, scor calculat in metoda profitOnGoods 
a clasei Score Calculator. Aici adaug bonusurile pentru cartile ilegale si calculez profitul pe ele, pe care il 
aduag in campul score al fiecarui jucator. Dupa, pentru a calcula bonusurile King si Queen, am decis sa fac o 
lista de HashMaps.(Am un hashMap pentru apple, unul pentru bread, etc.) In ele stochez strategia jucatorului si
frecventa bunului respectiv. La final calculez max si second max din fiecare hashmap, acord jucatorilor cu
frecventa bunului egal cu max bonusul King, iar celor cu second max bonusul Queen. Astfel, daca frecventa este
0 pentru toti jucatorii => max = 0 => fiecare jucator primeste King bonus. Adaug bonusurile in campul score.
Dupa ce se termina metoda ne intoarcem in print, de unde sortez vectorul de jucatori cu ajutorul lui ScoreCom-
parator dupa campul score, urmand ca mai apoi sa le printez in ordinea vectorului.