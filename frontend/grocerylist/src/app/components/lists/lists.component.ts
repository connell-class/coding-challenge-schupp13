import { Component, OnInit } from '@angular/core';
import { ListsService } from '../../services/lists.service';
import { List } from 'src/app/model/List';

@Component({
  selector: 'app-lists',
  templateUrl: './lists.component.html',
  styleUrls: ['./lists.component.css'],
})
export class ListsComponent implements OnInit {
  lists: List[] = [];
  constructor(private listService: ListsService) {}

  ngOnInit(): void {
    this.listService
      .getAllList()
      .then((data) => {
        this.lists = data;
        console.log(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }
}
