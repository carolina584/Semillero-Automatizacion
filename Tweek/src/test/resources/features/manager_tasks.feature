Feature: Gestión de tareas
  como usuario en la app web
  quiero administrar las tareas
  para su organizaciion y cumplimiento
  Background:
    Given usuario se encuentra en aplicativo Tweek

  Scenario Outline: Crear una nueva tarea
    When el usuario ingresa el título "<titulo>" y detalle "<detalle>"
    Then se visualizan "<titulo>" y descripción "<detalle>" de la tarea

    Examples:
      | titulo           | detalle                          |
      | Tarea 1          | Descripción de la tarea 1        |
      | Tarea importante | Esta tarea es muy importante     |
      | Tarea urgente    | Debe completarse antes de mañana |

  Scenario Outline: Consultar una tarea existente
    When el usuario busca la tarea
    Then visualizan el título "<titulo_mostrado>" y la descripción "<detalle_mostrado>" de la tarea

    Examples:
      | titulo_mostrado  | detalle_mostrado                 |
      | Tarea 1          | Descripción de la tarea 1        |
      | Tarea importante | Esta tarea es muy importante     |
      | Tarea urgente    | Debe completarse antes de mañana |

  Scenario Outline: Modificar una tarea existente
    When el usuario modifica el "<titulo_nuevo>" y "<detalle_nuevo>"
    Then se visualiza la informacion "<titulo_nuevo>"

    Examples:
      | titulo_nuevo     | detalle_nuevo                    |
      | Tarea Modificada | Descripción de la tarea 1        |
      | Tarea Modificada | Esta tarea es muy importante     |
      | Tarea Modificada | Debe completarse antes de mañana |

  Scenario: Eliminar una tarea
    When el usuario selecciona y elimina la tarea
    Then la tarea es eliminada

