# Opdrachtbeschrijving

## Inleiding

Je bent net begonnen als developer bij een bedrijf dat TV's verkoopt: Tech It Easy. Tijdens de cursus Spring Boot ga jij een backend applicatie programmeren voor het bedrijf. De winkel heeft een inventaris van televisies die moet worden bijgehouden. Na iedere les gaan we deze applicatie een stukje verder uitbouwen door middel van de huiswerkopdrachten. Zo krijg je stap-voor-stap meer ervaring in het bouwen van een backend applicatie. Aan het einde van de cursus zullen we een werkende Tech It Easy backend applicatie hebben!

## Recap van vorige opdracht

Je hebt inmiddels [je applicatie draaiende gekregen](https://github.com/hogeschoolnovi/backend-spring-boot-tech-it-easy-service-dto-uitwerkingen). Dit geeft je de mogelijkheid om in een database bij te houden welke tv's er zijn in de inventaris van TechItEasy. Als je de benamingen hebt aangehouden die we tot nu toe hebben gebruikt, kunnen we een _data.sql_ gaan maken waardoor we gegevens in de database kunnen zetten. Dit is een soort van pre-fill van je database. 

## Opdrachtbeschrijving
In deze opdracht ga je aan de slag met het toevoegen van relaties aan je applicatie.

## Randvoorwaarden
De opdracht moet voldoen aan de volgende voorwaarden:

Het project bevat de volgende `models`:
  - `Television`
  - `RemoteController` met de _variables_: 
    -_Long_`id`
    -_String_`compatibleWith`
    -_String_`batteryType`
    -_String_`name`
    -_String_`brand`
    -_Double_ `price`
    -_Integer_ `originalStock`
  - `CI-Module` met de _variables_:
    -_Long_ `id`
    -_String_ `name`
    -_String_ `type`
    -_Double_ `price`
  - `WallBracket` met de _variables_:
    -_Long_ `id`
    -_String_ `size`
    -_Boolean_ `adjustable`
    -_String_ `name`
    -_Double_ `price`
Voor elk van deze modellen bevat je applicatie ook een `Repository`, `Controller`, `Dto`, `InputDto` en een `Service`.

Daarnaast bevat het project:
- Een `OneToOne` relatie tussen `Television` en `RemoteController`
- Een `OneToMany` relatie tussen `Television` en `CI-Module`
- Een `ManyToMany` relatie tussen `Television`en `WallBracket`

### Belangrijk
Je mag de constructors uit de modellen weglaten. Deze vult Spring Boot automatisch in als ze niet gedefinieerd zijn. Ook uit de `Television` mogen de constructors verwijderd worden.

## Stappenplan
_Let op_: het is uitdagender om jouw eigen stappenplan te maken. Mocht je niet zo goed weten waar je moet beginnen, kun je onderstaand stappenplan volgen:

1. Maak in de map `models` een _klasse_ aan voor `RemoteController`, `CI-Module` en `WallBracket` (voeg de juiste _annotatie_, _variables_, _getters&setters_ en _constructors_ toe).
2. Maak in de map `repositories` voor elk model een `Repository` aan (die elk de `JpaRepository` _extends_ bevat).
3. Maak in de map `controllers` voor elk model een `Controller` aan (met juiste _annotatie_, constructor en _requestMappings_).
4. Maak in de map `dtos` voor elk model een `Dto` en `InputDto` aan (met juiste _variables_ en toewijzingen).
5. Maak in de map `services` voor elk model een `Service` aan (met juiste _annotatie_, constructor en _functions_).
6. Leg een OneToOne relatie tussen `Television` en `RemoteController` door in beide _models_ _@OneToOne_ toe te voegen, gevolgd door het model waar de relatie mee ligt in de vorm van `Model` `object` (bijvoorbeeld `Television` `television`) op de volgende regel.
7. Een OneToOne relatie heeft een eigenaar nodig. Maak de `Television` eigenaar door in `RemoteController` achter de _@OneToOne_ _mappedBy_ toe te voegen op deze manier _@OneToOne(mappedBy = "remotecontroller"). Dit zorgt ervoor dat in de `Television` tabel een kolom wordt toegevoegd met de naam `remotecontroller_id`. Vergeet niet de getter en setter toe te voegen na het leggen van de relatie in de modellen.
8. Om deze kolom te vullen zal je in _servicelaag_ ook een functie moeten maken die een koppeling maakt tussen de `Television` en de `RemoteController`. Dit doe je in de `TelevisionService`.
9. Voeg de functie "assignRemoteControllerToTelevision" toe in de `TelevisionService`. Zoals je ziet, herkent de `TelevisionService` de `RemoteControllerRepository` niet, dit komt omdat we deze nog niet gekoppeld hebben in de constructor, gelukkig hoef je niet alles opnieuw te doen. Je kan bovenaan in de `TelevisionService` onder de private `TelevisionRepository` een private `RemoteControllerRepository` declareren. En dan in de bestaande constructor deze toevoegen op dezelfde manier als de `TelevisionRepository`. Dit resulteert in: 

 ```java
 public TelevisionService (TelevisionRepository televisionRepository, 
                          RemoteControllerRepository remoteControllerRepository) {
    this.televisionRepository = televisionRepository;
    this.remoteControllerRepository = remoteControllerRepository;
}
 ```
 
10. Om deze functie uit te kunnen voeren moet je in de `TelevisionController` een _PutRequest_ maken met endpoint _"/televisions/{id}/remotecontroller"_ om aan te spreken. Voeg deze toe en geef de _televisionId_ mee als _@PathVariable_ en de _remoteControllerId_ als _@RequestBody_ door middel van een `IdInputDto` _input_.  
11. Hiervoor missen we nog de `IdInputDto`. Maak in het mapje `Dtos` een nieuwe klasse aan voor de `IdInputDto`. Declareer in deze dto een _public Long id_ toe, meer hoeft er niet in.
12. Gefeliciteerd, je hebt zo juist de eerste relatie gelegd in je applicatie!
13. Alleen als je nu met een get alle `Televisions` ophaalt, zie je geen `RemoteController`. Dit komt omdat we in de `TelevisionDto` nog niks hebben verteld over de `RemoteController`. De makkelijkste manier om hier de uitbreiding te leggen is de `public RemoteControllerDto remoteController;` toe te voegen aan de variabele van de `TelevisionDto` 
14. Test alle functies die je tot nu toe hebt gemaakt met Postman.

Je hebt nu de relatie tussen de televisie en remoteController gemaakt. Maak nu relatie tussen Televisie en CiModule en Televisie en Wallbracket.

Mocht je er niet uit komen:
<details>
<summary>
Stappenplan Televisie koppelen aan CiModule
</summary>

 
### Stap 1: De OneToMany relatie toevoegen

- Maak de Television eigenaar door in CiModule achter @OneToMany mappedBy toe te voegen.
- Voeg in Television @ManyToOne(fetch = FetchType.EAGER) en @JoinColumn(name = "ci_module_id") toe.
- Vergeet de getter en setter niet.

### Stap 2: Functie in de servicelaag maken

- Maak een functie in TelevisionService om een CiModule aan een Television te koppelen.

### Stap 3: Functie "assignCiModuleToTelevision" toevoegen

- Voeg in TelevisionService een private CiModuleRepository toe en initialiseer deze in de constructor.
- Voeg de functie assignCiModuleToTelevision toe.

### Stap 4: PutRequest in de controller maken

- Maak in de TelevisionController een PUT endpoint "/televisions/{id}/cimodule" aan.
- Gebruik @PathVariable voor televisionId en @RequestBody met een IdInputDto voor cimoduleId.

### Stap 5: Dto connectie maken

- Voeg in TelevisionDto de variabele public CiModuleDto ciModuleDto; toe.

### Stap 6: Functies testen met Postman

- Test alle functies die je tot nu toe hebt gemaakt met Postman.
- Test onder andere het koppelen van een CiModule aan een Television en het ophalen van alle Televisions om te controleren of de CiModule correct is gekoppeld.

</details>


<details>
<summary>
Stappenplan Televisie koppelen aan WallBracket
</summary>

### Stap 1: De ManyToMany relatie toevoegen

- Maak de Television eigenaar door in WallBracket achter @ManyToMany mappedBy toe te voegen.
- Voeg in Television
` @ManyToMany
  @JoinTable(name = "television_Wallbrackets",
   joinColumns @JoinColumn(name = "television"),
   inverseJoinColumns = @JoinColumn(name = "wallbracket")`
toe.
- Vergeet de getter en setter niet.

### Stap 2: Functie in de servicelaag maken

- Maak een functie in TelevisionService om een WallBracket aan een Television te koppelen.

### Stap 3: Functie "assignCiModuleToTelevision" toevoegen

- Voeg in TelevisionService een private WallBracketRepository toe en initialiseer deze in de constructor.
- Voeg de functie assignWallBracketToTelevision toe.

### Stap 4: PutRequest in de controller maken

- Maak in de TelevisionController een PUT endpoint "/televisions/{id}/WallBracket" aan.
- Gebruik @PathVariable voor televisionId en @RequestBody met een IdInputDto voor de WallBracket.

### Stap 5: Dto connectie maken

- Voeg in TelevisionDto de variabele public WallBracketDto wallBracketdto; toe.

### Stap 6: Functies testen met Postman

- Test alle functies die je tot nu toe hebt gemaakt met Postman.
- Test onder andere het koppelen van een WallBracket aan een Television en het ophalen van alle Televisions om te controleren of de WallBracket correct is gekoppeld.
  
</details>
