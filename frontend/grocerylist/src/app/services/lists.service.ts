import { Injectable } from '@angular/core';
import { List } from '../model/List';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ListsService {
  constructor(private http: HttpClient) {}

  /**
   * Getting all users in the database
   */
  public getAllList(): Promise<List[]> {
    return this.http
      .get<List[]>('http://localhost:8080/grocery-list/grocery-lists.app')
      .toPromise();
  }
}
