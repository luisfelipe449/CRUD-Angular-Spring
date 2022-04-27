import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, Observable, tap } from 'rxjs';
import { Course } from '../model/course';

@Injectable({
  providedIn: 'root',
})
export class CoursesService {
  private readonly API = '/api/produto';

  constructor(private httpClient: HttpClient) {}

  list() {
    return this.httpClient.get<Course[]>(this.API).pipe(
      first(),
      tap((courses) => console.log(courses))
    );
  }

  delete(id: string) {
    return this.httpClient.delete(`${this.API}/${id}`);
  }

  create(course: Course): Observable<Course>{
    return this.httpClient.post<Course>(this.API, course);
  }

  update(course: Course): Observable<Course>{
    return this.httpClient.put<Course>(`${this.API}/${course.id}`, course);
  }

}
