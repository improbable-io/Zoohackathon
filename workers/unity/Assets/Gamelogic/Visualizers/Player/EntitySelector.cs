﻿using UnityEngine;
using UnityEngine.UI;

namespace Assets.Gamelogic.Visualizers.Player 
{
	public class EntitySelector : MonoBehaviour 
	{
		public Camera PlayerCamera;
		public GameObject CurrentSelection;
		public GameObject UiText;

		void OnEnable()
		{
			PlayerCamera = GetComponentInChildren<Camera>();
			UiText = GameObject.Find("UiText");
		}

		void Update () 
		{
			if (Input.GetMouseButtonDown(0))
			{
				RaycastHit hit;
				Ray ray = PlayerCamera.ScreenPointToRay(Input.mousePosition);
				if (Physics.Raycast(ray.origin, ray.direction, out hit))
				{
                    Debug.Log("1");
                    if (hit.collider.gameObject.IsEntityObject())
					{
                        Debug.Log("2");
						GameObject newSelection = hit.collider.gameObject;
						if (newSelection != CurrentSelection)
						{
                            Debug.Log("3");
                            DeselectCurrent();
							CurrentSelection = newSelection;
                            SelectEntity(CurrentSelection);
						}
					}
					else
					{
						DeselectCurrent();
					}
				}
			}
		}

		void SelectEntity(GameObject entity)
		{
			if (!entity.IsEntityObject ()) 
			{
				return;
			}

			if (UiText != null) 
			{
				UiText.GetComponent<Text>().text = "Selected: " + entity.name;
			}
			else 
			{
				Debug.LogError("UiText is null");
			}
		}

		void DeselectCurrent()
		{
			CurrentSelection = null;
		}
	}
}
