import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from '../model/task.model';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  apiUrl = 'http://localhost:8080/tasks';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(
    private httpClient: HttpClient
  ) { }

  public getTasks(): Observable<Task[]> {
    return this.httpClient.get<Task[]>(this.apiUrl);
  }

  public createTask(task: any): Observable<Task> {
    return this.httpClient.post<any>(this.apiUrl, task, this.httpOptions);
  }

  public deleteTask(id: number): Observable<void> {
    return this.httpClient.delete<void>(this.apiUrl + '/' + id);
  }

  public updateDescription(task: Task): Observable<void> {
    return this.httpClient.put<void>(this.apiUrl + '/' + task.id, task, this.httpOptions);
  }

  public updateState(task: Task): Observable<void> {
    this.changeState(task);
    return this.httpClient.put<void>(this.apiUrl + '/' + task.id, task, this.httpOptions);
  }

  public changeState(task: Task) {
    if (task.state == "OPEN") {
      task.state = "DONE";
    } else {
      task.state = "OPEN"
    }
  }
}
