# Фабричный метод

Это порождающий паттерн проектирования, который определяет общий интерфейс для создания объектов в суперклассе,
позволяя подклассам изменять тип создаваемых объектов.

## Проблема

Паттерн Фабричный метод предлагает создавать объекты не напрямую, используя оператор new, а через вызов особого
фабричного метода. Все возвращаемые объекты должны иметь общий интерфейс. Подклассы смогут производить объекты различных
классов, следующих одному и тому же интерфейсу.

## Применимость

__Когда заранее неизвестны типы и зависимости объектов, с которыми должен работать ваш код.__
Фабричный метод отделяет код производства продуктов от остального кода, который эти продукты использует.
Благодаря этому, код производства можно расширять, не трогая основной. Так, чтобы добавить поддержку нового продукта,
вам нужно создать новый подкласс и определить в нём фабричный метод, возвращая оттуда экземпляр нового продукта.

__Когда вы хотите дать возможность пользователям расширять части вашего фреймворка или библиотеки.__ Пользователи могут
расширять классы вашего фреймворка через наследование. Но как сделать так, чтобы фреймворк создавал
объекты из этих новых классов, а не из стандартных?
Решением будет дать пользователям возможность расширять не только желаемые компоненты, но и классы, которые создают эти
компоненты. А для этого создающие классы должны иметь конкретные создающие методы, которые можно определить.

__Когда вы хотите экономить системные ресурсы, повторно используя уже созданные объекты, вместо порождения новых.__
Такая проблема обычно возникает при работе с тяжёлыми ресурсоёмкими объектами, такими, как подключение к базе данных,
файловой системе и т. д.

## Шаги реализации

1. Приведите все создаваемые продукты к общему интерфейсу.
2. В классе, который производит продукты, создайте пустой фабричный метод. В качестве возвращаемого типа укажите общий
   интерфейс продукта.
3. Затем пройдитесь по коду класса и найдите все участки, создающие продукты. Поочерёдно замените эти участки вызовами
   фабричного метода, перенося в него код создания различных продуктов.
   В фабричный метод, возможно, придётся добавить несколько параметров, контролирующих, какой из продуктов нужно
   создать. На этом этапе фабричный метод, скорее всего, будет выглядеть удручающе. В нём будет жить большой условный
   оператор, выбирающий класс создаваемого продукта. Но не волнуйтесь, мы вот-вот исправим это.
4. Для каждого типа продуктов заведите подкласс и переопределите в нём фабричный метод. Переместите туда код создания
   соответствующего продукта из суперкласса.
5. Если создаваемых продуктов слишком много для существующих подклассов создателя, вы можете подумать о введении
   параметров
   в фабричный метод, которые позволят возвращать различные продукты в пределах одного подкласса.
6. Если после всех перемещений фабричный метод стал пустым, можете сделать его абстрактным. Если в нём что-то осталось —
   не
   беда, это будет его реализацией по умолчанию.

## Преимущества и недостатки

Преимущества

* Избавляет класс от привязки к конкретным классам продуктов.
* Выделяет код производства продуктов в одно место, упрощая поддержку кода.
* Упрощает добавление новых продуктов в программу.
* Реализует принцип открытости/закрытости.

Недостатки

* Может привести к созданию больших параллельных иерархий классов, так как для каждого класса продукта надо создать свой
  подкласс создателя.

## Отношения с другими паттернами

1. Многие архитектуры начинаются с применения Фабричного метода (более простого и расширяемого через подклассы) и
эволюционируют в сторону Абстрактной фабрики, Прототипа или Строителя (более гибких, но и более сложных).

2. Классы Абстрактной фабрики чаще всего реализуются с помощью Фабричного метода, хотя они могут быть построены и на основе
Прототипа.

3. Фабричный метод можно использовать вместе с Итератором, чтобы подклассы коллекций могли создавать подходящие им
итераторы.

4. Прототип не опирается на наследование, но ему нужна сложная операция инициализации. Фабричный метод, наоборот, построен
на наследовании, но не требует сложной инициализации.

5. Фабричный метод можно рассматривать как частный случай Шаблонного метода. Кроме того, Фабричный метод нередко бывает
частью большого класса с Шаблонными методами.

[Источник](https://refactoring.guru/ru/design-patterns/factory-method)