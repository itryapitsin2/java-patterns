# ПРИНЦИП РАБОТЫ
Железнодорожная сеть из двух типов колеи представлена ввиде двунаправленного графа.
Пусть колея типа `R` будет прямым направлянием, а тип `B` - обратным.
Тогда задача сводится к поиску цикла в графе.
Для поиска цикла используется алгоритм обхода в глубену (DFS).
Если алгоритм находит цикл, то такая карта является не оптимальной.
Соответственно, карта без цикла - оптимальная.

# ВРЕМЕННАЯ СЛОЖНОСТЬ
Проходим только по всем "белым" вершинам, т.е.
`O(V - V1)`, где
`V` - общее количество вершин графа.
`V1` - количество вершин обратного направления.

# ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
Храним список вешин, списк граней, т.е. `O(V + E)`, но используя стэк мы храним только необходимые вершины.
В худшем случае это `O(V)`.
